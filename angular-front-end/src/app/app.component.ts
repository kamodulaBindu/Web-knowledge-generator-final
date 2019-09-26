import { Component } from '@angular/core';
import { SpeechService } from './speech.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'web-knowlwdge-generator';
  constructor(public speech: SpeechService) {}
}
