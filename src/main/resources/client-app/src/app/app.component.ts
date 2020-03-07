import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'farm-app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client-app';

  constructor(private router: Router){}

  logout() {
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }
}
