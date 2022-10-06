import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
export interface user {
  username: string;
  password: string;
  repassword: string;
  email: string;
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  u: user = {
    username: "",
    password: "",
    repassword: "",
    email: ""
  };
  constructor(private router: Router) {}
  username: string='';
  password:string='';
  ngOnInit() {}
  login(u) {
    console.log("login called");
    console.log(u.username,u.password);
    
    if (u.username === 'ad' && u.password === 'ad') {
      console.log('in admin');
      sessionStorage.setItem('role', 'admin');
      this.router.navigateByUrl("role/admin/adminbash");
    }
    if (u.username === 'ac' && u.password === 'ac') {
      console.log('in acount section');
      sessionStorage.setItem('role', 'account');
      this.router.navigateByUrl("role/account/loanlist");
      // this.router.navigateByUrl("role/account/ledgerform");
      // this.router.navigateByUrl("role/account/ledgerview")
    }
    if (u.username === 'oe' && u.password === 'oe') {
     
      sessionStorage.setItem('role', 'operation');
      this.router.navigateByUrl("role/operation/oedash");
    }
    if (u.username === 'cm' && u.password === 'cm') {
      console.log(u.username,u.password);
      sessionStorage.setItem('role', 'cr');
      this.router.navigateByUrl("role/cr/credit");
    }
    if (u.username === 're' && u.password === 're') {
      console.log(u.username,u.password);
      sessionStorage.setItem('role', 'relation');
      this.router.navigateByUrl("role/relation/oecustomer");
    }
    if (u.username === 'abc' && u.password === 'abc') {
      console.log(u.username,u.password);
      sessionStorage.setItem('role', 'ab');
      this.router.navigateByUrl("role/ab/abcdash");
    }
    
  }
  signup(u) {
    console.log("signup");
  }
}
