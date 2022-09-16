import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const API_URL = "http://localhost:8082/api/v1/digitalbooks/auth/";
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(public client: HttpClient) { }

  public addUser(user: any) {
    return this.client.post(API_URL + "signup/", user);
  }

  login(username: string, password: string): Observable<any> {
    return this.client.post(API_URL + 'signin', {
      username,
      password
    }, httpOptions);
  }
}
