import { Component, OnInit, Inject } from '@angular/core';

import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { FeedbackComponent } from '../feedback/feedback.component';
import { ContactUsComponent } from '../contact-us/contact-us.component';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  animal: string;
  name: string;
  constructor(public dialog: MatDialog) { }
  openFeedbackDialog(): void {
    const dialogRef = this.dialog.open(FeedbackComponent, {
      width: '250px',
      data: {name: this.name, animal: this.animal}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }

  openContactDialog(): void {
    const dialogRef = this.dialog.open(ContactUsComponent, {
      width: '250px',
      data: {name: this.name, animal: this.animal}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }




  ngOnInit() {
  }

}
