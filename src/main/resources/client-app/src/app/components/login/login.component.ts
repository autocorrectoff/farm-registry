import { Component, OnInit } from '@angular/core';
import { RepositoryService } from 'src/app/services/repository.service';
import { Router } from '@angular/router';

@Component({
  selector: 'farm-app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string;
  password: string;
  showErrorMessage = false;

  constructor(private repository: RepositoryService, private router: Router) { }

  ngOnInit() {
  }

  login(){
    this.repository.create('users/login', {email: this.email, password: this.password}).subscribe(response => {
        console.log(response);
        localStorage.setItem('user', JSON.stringify(response));
        this.router.navigate(['/farms']);
    }, err => {
      if(err.status == 404) {
        this.showErrorMessage = true;
      }
    });
  }

}
