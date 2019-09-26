import { Router } from "@angular/router";
import { Component, OnInit, OnDestroy } from "@angular/core";
import { SpeechService } from "./../speech.service";
import { Subscription } from "rxjs/Subscription";
import "rxjs/add/operator/filter";
import "rxjs/add/operator/map";
import { Observable } from "rxjs/internal/Observable";
import { WebSocketAPI } from "../WebSocketAPI";

@Component({
  selector: "app-search-bar",
  templateUrl: "./search-bar.component.html",
  styleUrls: ["./search-bar.component.css"]
})
export class SearchBarComponent implements OnInit {

  name: string="";
  greeting: string;
  message: string;

  nouns: string[];
  verbs: string[];
  adjs: string[];
  nounSub: Subscription;
  verbSub: Subscription;
  adjSub: Subscription;
  errorsSub: Subscription;
  errorMsg: string;
  constructor( private router:Router,public speech: SpeechService, public webSocketAPI: WebSocketAPI) { }

  ngOnInit() {
    this.speech.init();
    this._listenNouns();
    this._listenVerbs();
    this._listenAdj();
    this._listenErrors();
    this.name = "";
    this.webSocketAPI._connect();

    if(this.name == ""){

       this.name=localStorage.getItem('searchString');

       this.sendMessage();
    }
//        localStorage.setItem('searchString',"");
  }
        

  get btnLabel(): string {
    return this.speech.listening ? "Listening..." : "";
  }
  listentext() {
    this.name = "";
    console.log(this.name);
    this.speech.startListening();
  }

  private _listenNouns() {
    this.nounSub = this.speech.words$
      .filter(obj => obj.type === "noun")
      .map(nounObj => nounObj.word)
      .subscribe(noun => {
        this._setError();
        console.log("noun:", noun);
      });
  }

  private _listenVerbs() {
    this.verbSub = this.speech.words$
      .filter(obj => obj.type === "verb")
      .map(verbObj => verbObj.word)
      .subscribe(verb => {
        this._setError();
        console.log("verb:", verb);
      });
  }

  private _listenAdj() {
    this.adjSub = this.speech.words$
      .filter(obj => obj.type === "adj")
      .map(adjObj => adjObj.word)
      .subscribe(adj => {
        this._setError();
        console.log("adjective:", adj);
      });
  }

  private _listenErrors() {
    this.errorsSub = this.speech.errors$.subscribe(err => this._setError(err));
  }

  private _setError(err?: any) {
    if (err) {
      console.log("Speech Recognition:", err);
      this.name = err.obj.results[0];
      this.errorMsg = err.message;
    } else {
      this.errorMsg = null;
    }
  }

  ngOnDestroy() {
    this.nounSub.unsubscribe();
    this.verbSub.unsubscribe();
    this.adjSub.unsubscribe();
    this.errorsSub.unsubscribe();
  }

  _connect() {}

  disconnect() {
    this.webSocketAPI._disconnect();
  }
  keyDownFunction(event) {
    if(event.keyCode == 13) {
      console.log('aya');
      this.sendMessage();
    }
  }
  sendMessage() {
    console.log(this.name);
   if(this.name){
        localStorage.setItem('searchString', this.name);
        this.webSocketAPI._send(this.name);
        this.router.navigateByUrl('content');
      }
  }
}
