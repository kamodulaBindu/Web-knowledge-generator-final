import * as Stomp from "stompjs";
import * as SockJS from "sockjs-client";
import { AppComponent } from "./app.component";
import { BehaviorSubject } from "rxjs";
import { Injectable } from "@angular/core";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: "root"
})
export class WebSocketAPI {
  webSocketEndPoint: string = environment.notificationURL;

  topic: string = "/topic/result";
  stompClient: any;

  private resultDataSource = new BehaviorSubject<string>("");
  resultData = this.resultDataSource.asObservable();
  private suggestionsDataSource = new BehaviorSubject<string>("");
  suggestionsData = this.suggestionsDataSource.asObservable();

  constructor() {}

  _connect() {
    console.log("Initialize WebSocket Connection");
    let ws = new SockJS(this.webSocketEndPoint);
    this.stompClient = Stomp.over(ws);
    const _this = this;
    _this.stompClient.connect(
      {},
      function(frame) {
        _this.stompClient.subscribe(_this.topic, function(sdkEvent) {
          _this.onMessageReceived(sdkEvent);
        });
      },
      this.errorCallBack
    );
  }

  _disconnect() {
    if (this.stompClient !== null) {
      this.stompClient.disconnect();
    }
    console.log("Disconnected");
  }

  // on error, schedule a reconnection attempt
  errorCallBack(error) {
    console.log("errorCallBack -> " + error);
    setTimeout(() => {
      this._connect();
    }, 5000);
  }

  /**
   * Send message to sever via web socket
   * @param {*} message
   */
  _send(message) {
    console.log("calling logout api via web socket");
    this.stompClient.send("/app/search", {}, JSON.stringify(message));
  }

  onMessageReceived(message) {
    console.log("recieved message from backend");
    let messageData = JSON.parse(message.body);
    let messageString = messageData.content as string;
    let result = JSON.parse(messageString);
    this.resultDataSource.next(result.node);
    this.suggestionsDataSource.next(result.suggestions);
    console.log("Message Recieved from Server :: " + {}, messageString);
  }
}
