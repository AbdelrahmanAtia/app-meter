import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuditInfoComponent } from './_components/audit-info/audit-info.component';
import { AuditsComponent } from './_components/audit-list/audits.component';

const routes: Routes = [
  {
    path: '',
    component: AuditsComponent,
    data: {
      title: 'Auditing'
    }
  },
  {
    path: 'auditInfo/:auditId',
    component: AuditInfoComponent,
    data: {
      title: 'Audit-Info'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuditsRoutingModule { } 
