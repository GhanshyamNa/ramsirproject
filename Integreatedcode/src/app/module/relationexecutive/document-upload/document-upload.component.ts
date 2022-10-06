import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CommonreService } from 'app/module/shared/commonre.service';

@Component({
  selector: 'app-document-upload',
  templateUrl: './document-upload.component.html',
  styleUrls: ['./document-upload.component.css']
})
export class DocumentUploadComponent implements OnInit {
  constructor(public cs:CommonreService,public fb:FormBuilder,private routes:ActivatedRoute,private loc:Location) { }
  registrationForm:FormGroup;
  retrievedDoc:any
  custId:number;
  ngOnInit(): void {
    this.registrationForm=this.fb.group({
    

    docId:[],
    photo:[''],
    signature:[''],
    panCard:[''],
    addressProof:[''],
    incomeDocument:[''],
    aadharCard:[''],
    propertyDocument:[''],
    blankchecque:[''],
    appId:this.fb.group({
     // applicationId:[]
      
    })
   

    })
    this.update()
    let s:any=this.loc.getState();
    console.log(s.customerId);
    this.custId=s.customerId;
  }

  selectedphoto:any
  selectedsignature:any
  selectedpanCard:any
  selectedaddressProof:any
  selectedincomeDocument:any
  selectedaadharCard:any
  selectedpropertyDocument:any
  selectedblankchecque:any

  update()
  {
    this.routes.paramMap.subscribe
    {
      param1=>
      {
        
        let id=parseInt(param1.get('customerId'));
        this.registrationForm.get('applicationId').setValue(id);
      }
    }
  }

  onsubmit( ){
   
    alert("welcome")
    const document1=JSON.stringify(this.registrationForm.value);
    console.log("Applicant IS:"+ this.registrationForm.get('apId')?.value.applicationId)
    //console.log(this.registrationForm.controls.apId.)
	// create object formdata
    const uploadDocument= new FormData();
	// store file formdata
    uploadDocument.append("photo",this.selectedphoto);
    uploadDocument.append("signature",this.selectedsignature);
    uploadDocument.append("panCard",this.selectedpanCard);
    uploadDocument.append("addressProof",this.selectedaddressProof);
    uploadDocument.append("incomeDocument",this.selectedincomeDocument);
    uploadDocument.append("aadharCard",this.selectedaadharCard);
    uploadDocument.append("propertyDocument",this.selectedpropertyDocument);
    uploadDocument.append("blankchecque",this.selectedblankchecque);
    uploadDocument.append("doc",document1);
 
    this.cs.postDocument(this.custId,uploadDocument).subscribe();
    console.log("Upload Method")
  
  
     
  }
  onselectedFile1(event:any)
  {
    //alert("hello")
    this.selectedphoto=event.target.files[0];
  alert(this.selectedphoto);
  // const file = event.target.files[0];
  // this.reader.onload = e => this.imageSrc1 = this.reader.result;
  // this.reader.readAsDataURL(file);
  }
 
  onselectedFile2(event:any){this.selectedsignature=event.target.files[0];}
  onselectedFile3(event:any){this.selectedpanCard=event.target.files[0];}
  onselectedFile4(event:any){this.selectedaddressProof=event.target.files[0];}
  onselectedFile5(event:any){this.selectedincomeDocument=event.target.files[0];}
  onselectedFile6(event:any){this.selectedaadharCard=event.target.files[0];}
  onselectedFile7(event:any){this.selectedpropertyDocument=event.target.files[0];}
  onselectedFile8(event:any){this.selectedblankchecque=event.target.files[0];}


  goBack(){

    this.cs.getdataDocument().subscribe((data:[])=>{

    this.retrievedDoc=data;
    })
  }

}
