import { CmServiceService } from './../../shared/cm-service.service';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import jsPDF from 'jspdf';
import  html2canvas  from 'html2canvas';
import { SanctionLetter } from 'app/model/sanction-letter';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-sanction-letter-generator',
  templateUrl: './sanction-letter-generator.component.html',
  styleUrls: ['./sanction-letter-generator.component.css']
})
export class SanctionLetterGeneratorComponent implements OnInit {

  @ViewChild('sanctionletter') sanctionletter!: ElementRef;

  sanctionObj: SanctionLetter;

  id:number;

  constructor(public common : CmServiceService,private routes : ActivatedRoute,public location :Location) { }
  
  ngOnInit(): void { 
      this.routes.paramMap.subscribe((param=>{
        this.common.getDataForLetter(parseInt(param.get('id'))).subscribe(data=>{
          this.sanctionObj = data;
        })
      }))
  }
  goBack()
  {
    this.location.back();
  }

  public generatePDF() : void
  {
      let DATA: any = document.getElementById('sanctionletter');
      html2canvas(DATA).then((canvas) => {
        let fileWidth = 208;
        let fileHeight = (canvas.height * fileWidth) / canvas.width;
        const FILEURI = canvas.toDataURL('image/png');
        let PDF = new jsPDF('p', 'mm', 'a4');
        let position = 0;
        PDF.addImage(FILEURI, 'PNG', 0, position, fileWidth, fileHeight);
        PDF.save('sanction-letter.pdf');
      });
    }
}
