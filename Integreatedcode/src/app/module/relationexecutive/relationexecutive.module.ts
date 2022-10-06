import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerregisterComponent } from './customerregister/customerregister.component';
import { DocumentComponent } from './document/document.component';
import { EnquiryComponent } from './enquiry/enquiry.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmailSendingComponent } from './email-sending/email-sending.component';
import { ApplicantRegistrationComponent } from './applicant-registration/applicant-registration.component';
import { DocumentUploadComponent } from './document-upload/document-upload.component';


const routing: Routes = [
  {path: 'oeenquiry', component:EnquiryComponent },
  {path:'oecustomer',component:CustomerregisterComponent,
    children:[
      {
        path:'register',component:ApplicantRegistrationComponent
      },
      {
        path:'uploaddoc',component:DocumentUploadComponent
      }
    ]},
  {path:'oedocument',component:DocumentComponent,
  children:[{path:'oeemail',component:EmailSendingComponent}]},
  {path:'oeAppReg',component:ApplicantRegistrationComponent},
  {path:'oedocumentupload',component:DocumentUploadComponent},
  
  
  // children:[{path:'oeemail',component:EmailSendingComponent}]}
  
  
];
@NgModule({
  declarations: [CustomerregisterComponent, DocumentComponent, EnquiryComponent,EmailSendingComponent, ApplicantRegistrationComponent, DocumentUploadComponent],
  imports: [
    CommonModule,RouterModule.forChild(routing),
    ReactiveFormsModule,FormsModule
  ]
})
export class RelationexecutiveModule { }
