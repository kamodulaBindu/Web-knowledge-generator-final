

import{Router} from '@angular/router'
import { Component, OnInit, OnDestroy } from '@angular/core';
import { SpeechService } from './../speech.service';
import { Subscription } from 'rxjs/Subscription';
import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  nouns: string[];
  verbs: string[];
  adjs: string[];
  nounSub: Subscription;
  verbSub: Subscription;
  adjSub: Subscription;
  errorsSub: Subscription;
  errorMsg: string;
  public searchtext='';
  constructor(private router:Router,public speech: SpeechService) { }

  ngOnInit() {
    this.speech.init();
    this._listenNouns();
    this._listenVerbs();
    this._listenAdj();
    this._listenErrors();
    localStorage.setItem('searchString',"");
  }
  search(){
    this.router.navigateByUrl('content');
  }
  get btnLabel(): string {
    return this.speech.listening ? 'Listening...' : '';
  }
  listentext(){

    this.searchtext='';
    console.log(this.searchtext);
    this.speech.startListening();
  }

  private _listenNouns() {
    this.nounSub = this.speech.words$
      .filter(obj => obj.type === 'noun')
      .map(nounObj => nounObj.word)
      .subscribe(
        noun => {
          this._setError();
          console.log('noun:', noun);
        }
      );
  }

  private _listenVerbs() {
    this.verbSub = this.speech.words$
      .filter(obj => obj.type === 'verb')
      .map(verbObj => verbObj.word)
      .subscribe(
        verb => {
          this._setError();
          console.log('verb:', verb);
        }
      );
  }

  private _listenAdj() {
    this.adjSub = this.speech.words$
      .filter(obj => obj.type === 'adj')
      .map(adjObj => adjObj.word)
      .subscribe(
        adj => {
          this._setError();
          console.log('adjective:', adj);
        }
      );
  }

  private _listenErrors() {
    this.errorsSub = this.speech.errors$
      .subscribe(err => this._setError(err));
  }

  private _setError(err?: any) {
    if (err) {
      console.log('Speech Recognition:', err);
      this.searchtext = err.obj.results[0];
      this.errorMsg = err.message;
    } else {
      this.errorMsg = null;
    }
  }

  login(){
    // alert("hello");
    console.log(localStorage.getItem('username'));
    if( localStorage.getItem('username')){
      if( localStorage.getItem('username')!='undefined'){
        this.router.navigate(["domainexpert"]);
      } else{
        this.router.navigate(["login"]);
      }
    }else{
      this.router.navigate(["login"]);
    }
    
   }

  ngOnDestroy() {
    this.nounSub.unsubscribe();
    this.verbSub.unsubscribe();
    this.adjSub.unsubscribe();
    this.errorsSub.unsubscribe();
  }
}
