import { Component, OnInit } from '@angular/core';
import { Cibil } from 'app/model/cibil';
import { CommonreService } from 'app/module/shared/commonre.service';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css']
})
export class DocumentComponent implements OnInit {
  constructor(public cs:CommonreService) { }
  cib:Cibil[];
  ngOnInit(): void {
    this.cs.geteCibil().subscribe((data:Cibil[])=>{
      this.cib=data;
    })
  }

}
