import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuditsRoutingModule } from './audits-routing.module';
import { FormsModule } from '@angular/forms';
import { ChartsModule } from 'ng2-charts';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { AuditInfoComponent } from './_components/audit-info/audit-info.component';
import { AuditsComponent } from './_components/audit-list/audits.component';

@NgModule({
  imports: [
    CommonModule,
    AuditsRoutingModule,
    FormsModule,
    ChartsModule,
    BsDropdownModule,
    ButtonsModule.forRoot()
  ],
  declarations: [AuditsComponent, AuditInfoComponent],
})
export class AuditsModule { }
