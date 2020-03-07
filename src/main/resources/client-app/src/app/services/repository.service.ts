import { Observable, throwError } from 'rxjs/';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { EnvironmentService } from './environment.service';
import { catchError } from 'rxjs/operators';
import { ErrorHandlerService } from './error-handler.service';

@Injectable({
  providedIn: 'root'
})
export class RepositoryService {
  protected url: string;
  constructor(protected http: HttpClient, protected envService: EnvironmentService,
              protected errorService: ErrorHandlerService) {
    this.url = this.envService.urlAddress;
  }

  public getData(route: string): Observable<any[]> {
    return this.http.get<any[]>(this.createCompleteRoute(route, this.url), this.generateHeaders())
    .pipe(catchError(this.handleErrors));
  }

  public getOne(route: string): Observable<any> {
    return this.http.get<any>(this.createCompleteRoute(route, this.url), this.generateHeaders())
    .pipe(catchError(this.handleErrors));
  }

  public create(route: string, body): Observable<any> {
    return this.http.post<any>(this.createCompleteRoute(route, this.url), body, this.generateHeaders())
    .pipe(catchError(this.handleErrors));
  }

  public update(route: string, body): Observable<any> {
    return this.http.put<any>(this.createCompleteRoute(route, this.url), body, this.generateHeaders())
    .pipe(catchError(this.handleErrors));
  }

  public delete(route: string): Observable<void> {
    return this.http.delete<void>(this.createCompleteRoute(route, this.url), this.generateHeaders())
    .pipe(catchError(this.handleErrors));
  }

  private createCompleteRoute(route: string, envAddress: string) {
    return `${envAddress}/${route}`;
  }

  private generateHeaders() {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
  }

  private handleErrors(httpError: HttpErrorResponse) {
    if (httpError.error instanceof ErrorEvent) {
      console.error('Client error', httpError.error.message);
    } else {
      console.error('Server error', httpError);
    }
    return throwError(httpError);
  }
}
