import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuditInfo } from '../../_models/audit-info.model';
import { AuditsService } from '../../_services/audits.service';


@Component({
  templateUrl: './audits.component.html',
})
export class AuditsComponent implements OnInit {

  auditInfoList: AuditInfo[] = [];
  constructor(private auditsService: AuditsService,
              private router: Router) { }

  ngOnInit(): void {
    console.log('initializing audits component..');

    this.auditsService.getAllAudits().subscribe(
      (auditInfoList: AuditInfo[]) => {
        console.log(auditInfoList);
        this.auditInfoList = auditInfoList;
      },
      (error) => {
        console.log(error);
      }
    );

  }



  viewAuditDetails(): void {
    console.log('viewing full audit entry details')
    this.router.navigate(['/audits/auditInfo']);
  }


}