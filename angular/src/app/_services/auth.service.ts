import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from '../_models/LoginRequest';
import { RegisterRequest } from '../_models/RegisterRequest';
import { map } from 'rxjs/operators';
import { LoginResponse } from '../_models/LoginResponse';
import { Observable, Subject } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  API_URL: string = "http://localhost:8080/api"

  constructor(private http: HttpClient) { }

  public logger = new Subject<boolean>();

  isUserLoggedIn(): Observable<boolean> {
    return this.logger.asObservable()
  }

  login(loginRequestData: LoginRequest, role: string): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.API_URL}/${role}s/login`, loginRequestData).pipe(map(response => {
      return response;
    }))
  }

  registerClient(registerRequestData: RegisterRequest): Observable<RegisterRequest> {
    return this.http.post<RegisterRequest>(`${this.API_URL}/clients/register`, registerRequestData).pipe(map(response => {
      return response;
    }))
  }

  deconnexion(): boolean {
    localStorage.clear()
    this.logger.next(false);
    return true;
  }
}
