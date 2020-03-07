import { Injectable, Injector } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs/';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private injector: Injector) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {

    if(request.method == 'OPTIONS') {
      return next.handle(request);
    }
    if(request.url.includes('users')) {
      return next.handle(request);
    }
    
    const userId = JSON.parse(localStorage.getItem('user')).id;

    request = request.clone({
      setHeaders: {
        userId: userId.toString()
      }
    });
    return next.handle(request);
  }
}