import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { AuditInfo } from '../../_models/audit-info.model';
import { AuditService } from '../../_services/audit.service';

@Component({
  templateUrl: './audit-info.component.html',
})
export class AuditInfoComponent implements OnInit {

  auditInfo: AuditInfo = new AuditInfo();

  constructor(private auditService:AuditService) { }

  ngOnInit(): void {
    this.auditService.getAuditInfoById(1).subscribe(
      (response:AuditInfo) => {
        console.log(response);
        this.auditInfo = response;
      },
      (error) => console.log(error)
    );
  }

}
