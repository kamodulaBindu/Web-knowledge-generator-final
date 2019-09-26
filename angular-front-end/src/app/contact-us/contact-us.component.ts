import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';


@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ContactUsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ContactUsComponent,) {}


  ngOnInit() {
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
}
