import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  headers = new HttpHeaders({ 'Access-Control-Allow-Origin': '*' })

  // constructor
  constructor(private http: HttpClient) { }

  // authenticate the user as domain expert
  authenticateDomainExpert(userName, userPassword) {
    return this.http.get(environment.loginURL + "/api/v1?userName=" + userName + "&&userPassword=" + userPassword,
      {
      headers: this.headers 
        });
  }

  // populate data by domain expert
  populateData(concepts): Observable<any> {
    return this.http.post(environment.populationURL+ "/" + concepts,
      {
        headers: this.headers
         
      }
    );
  }
}
