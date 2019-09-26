import { Component, OnInit, ViewChild } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginServiceService } from '../service/login-service.service';


export interface Domain {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-domain',
  templateUrl: './domainexpert.component.html',
  styleUrls: ['./domainexpert.component.css']
})
export class DomainComponent  {
  constructor(private router: Router, private _loginService:LoginServiceService) { }
  public csvRecords: any[] = [];
  public dataArr = [];
  public concept:any="";
  public concepts:any=[];
  public domainarr:any=""


  populate()
{

console.log(this.concept)
if(this.concept != ""){
 console.log('yes');
  this.concepts = this.concept.split(",");
  console.log(this.concepts);
}
console.log(this.concepts);
if(this.dataArr.length> 0 ){
  for(var i=0;i<this.dataArr.length;i++){
    this.concepts.push(this.dataArr[i].title)
}
  alert("Data is populated");
}

this._loginService.populateData(this.concepts).subscribe();

// this.HTMLOutputElement.post('${this.uri}/add',obj)
// .subscribe(res=>console.log('Done'));

}

 click(file1){
    alert(1);
    console.log(file1);
  }

  logout(){
    localStorage.setItem('username', undefined);
    localStorage.setItem('password', undefined);
    this.router.navigate([""]);
   }

  isCSVFile(file: any) {
   return file.name.endsWith(".csv");
 }
 getHeaderArray(csvRecordsArr: any)
 {
    let headers = csvRecordsArr[0].split(',');
    let headerArray = [];

    for (let j = 0; j < headers.length; j++) {
                headerArray.push(headers[j]);
    }
   return headerArray;
 }
 getDataRecordsArrayFromCSVFile(csvRecordsArray: any, headerLength: any)
{

          this.dataArr = []

          for (let i = 1; i < csvRecordsArray.length-1; i++) {
               let data = csvRecordsArray[i].split(',');
               // FOR EACH ROW IN CSV FILE IF THE NUMBER OF COLUMNS
               // ARE SAME AS NUMBER OF HEADER COLUMNS THEN PARSE THE DATA

               if (data.length == headerLength) {
                    var csvRecord: CSVRecord = new CSVRecord();
                    csvRecord.title = data[0].trim();
                    this.dataArr.push(csvRecord);
                    // console.log(dataArr);
                    // alert(dataArr['CSVRecord']);
               }
           }
         console.log(this.dataArr);
    return this.dataArr;
}
fileChangeListener($event: any): void {
  var text = [];
  var files = $event.srcElement.files;

  if (this.isCSVFile(files[0])) {
     var input = $event.target;
     var reader = new FileReader();
     reader.readAsText(input.files[0]);

     reader.onload = (data) => {
          let csvData = reader.result;
          let csvRecordsArray = (csvData as String).split(/\r\n|\n/);
          let headersRow = this.getHeaderArray(csvRecordsArray);
          this.csvRecords =
             this.getDataRecordsArrayFromCSVFile(csvRecordsArray,
              headersRow.length);         }

             reader.onerror = function() {
                 alert('Unable to read' + input.files[0]);
             };
    } else {
           alert('Please import valid .csv file.');
           //this.fileReset();
    }
}
 domainControl = new FormControl('', [Validators.required]);

  domains: Domain[] = [
    {value: 'Movie-0', viewValue: 'Movie'},

  ];


}

export class CSVRecord {

  public title: any;
  constructor() {

  }}
