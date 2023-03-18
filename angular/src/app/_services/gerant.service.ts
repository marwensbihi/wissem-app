import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GerantService {

  API_URL: string = "http://localhost:8080/api"

  constructor(private http: HttpClient) { }

  registerGerant(registerRequestData: any): Observable<any> {
    return this.http.post<any>(`${this.API_URL}/gerants/register`, registerRequestData).pipe(map(response => {
      return response;
    }))
  }

  getGerants(): Observable<any> {
    return this.http.get<any>(`${this.API_URL}/gerants`).pipe(map(response => {
      return response;
    }))
  }

  deleteGerant(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.API_URL}/gerants/${id}`).pipe(map(response => {
      return response;
    }))
  }
}
