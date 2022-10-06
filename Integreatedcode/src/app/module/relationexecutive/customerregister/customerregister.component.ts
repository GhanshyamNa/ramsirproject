import { Customer } from './../../../../../../OeModule/src/app/model/customer';
import { Component, OnInit } from '@angular/core';

import { CommonreService } from 'app/module/shared/commonre.service';

@Component({
  selector: 'app-customerregister',
  templateUrl: './customerregister.component.html',
  styleUrls: ['./customerregister.component.css']
})
export class CustomerregisterComponent implements OnInit {

  constructor(public cs:CommonreService) { }
  std:Customer[];
  ngOnInit(): void {
    this.cs.getedata().subscribe((data:Customer[])=>{
      this.std=data;
    })
  }

}
