import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { throwError, ObservableInput } from 'rxjs/';

@Injectable({
  providedIn: 'root'
})
export class ErrorHandlerService {
  public errorMessage = '';

  constructor(private router: Router) { }

  public handleError(error: HttpErrorResponse) {
    if (error.status === 500) {
      this.handle500Error(error);
    } else if (error.status === 404) {
      this.handle404Error(error);
    } else {
      this.handleOtherError(error);
    }
  }

  private handle500Error(error: HttpErrorResponse) {
    this.createErrorMessage(error);
    this.router.navigate(['/login']);
  }

  private handle404Error(error: HttpErrorResponse) {
    this.createErrorMessage(error);
    this.router.navigate(['/login']);
  }

  private handleOtherError(error: HttpErrorResponse) {
    this.createErrorMessage(error);
    // TODO: this will be fixed later;
  }

  private createErrorMessage(error: HttpErrorResponse) {
    this.errorMessage = error.error ? error.error : error.statusText;
    return throwError('');
  }

}
