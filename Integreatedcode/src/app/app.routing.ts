import { Routes } from '@angular/router';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { LoginComponent } from './login/login.component';

import { HomeComponent } from './home/home.component';
import { OperationexecutiveModule } from './module/operationexecutive/operationexecutive.module';
import { CreditmanagerModule } from './module/creditmanager/creditmanager.module';
import { RelationexecutiveModule } from './module/relationexecutive/relationexecutive.module';

import { DisburseModule } from './module/disburse/disburse.module';


export const AppRoutes: Routes = [
  {
    path: '',
    component: HomeComponent
  }, 
  {
    path:"log",component:LoginComponent
  }
,
  {
    path: 'role',
    component: AdminLayoutComponent,
    children: [
      {path: 'admin', loadChildren: () => MastermoduleModule},
      {path: 'account', loadChildren: () => DisburseModule},
      {path:'operation',loadChildren:()=>OperationexecutiveModule},
      {path:'cr',loadChildren:()=>CreditmanagerModule},
      {path:'relation',loadChildren:()=>RelationexecutiveModule}
   
    ]
  },
  {
    path: '**',
    redirectTo: 'dashboard'
  }
];



