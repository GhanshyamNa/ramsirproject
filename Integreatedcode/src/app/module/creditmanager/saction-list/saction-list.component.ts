import { CmServiceService } from './../../shared/cm-service.service';
import { Component, OnInit } from '@angular/core';
import { SanctionLetter } from 'app/model/sanction-letter';

@Component({
  selector: 'app-saction-list',
  templateUrl: './saction-list.component.html',
  styleUrls: ['./saction-list.component.css']
})
export class SactionListComponent implements OnInit {

    constructor(public common : CmServiceService) { }
  
  sanctionList : SanctionLetter[];

  ngOnInit(): void {
    this.common.getAllSanctionLetterData().subscribe((data:SanctionLetter[])=>{
      this.sanctionList = data;
    })
  }

}
