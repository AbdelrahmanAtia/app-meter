import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuditInfo } from '../../_models/audit-info.model';
import { AuditService } from '../../_services/audit.service';
import { DataService } from '../../_services/data.service';


@Component({
  templateUrl: './audits.component.html',
})
export class AuditsComponent implements OnInit {

  auditInfoList: AuditInfo[] = [];
  constructor(private auditService: AuditService,
              private router: Router) { }

  ngOnInit(): void {
    console.log('initializing audits component..');

    this.auditService.getAllAudits().subscribe(
      (auditInfoList: AuditInfo[]) => {
        console.log(auditInfoList);
        this.auditInfoList = auditInfoList;
      },
      (error) => {
        console.log(error);
      }
    );

  }

  viewAuditDetails(auditId:number): void {
    console.log('view audit entry details with id: ' + auditId);
    this.router.navigate(['/audits/auditInfo/', auditId]);
    /*
    this.auditInfoList.forEach(element => {
      if(element.id == auditId){
        console.log('element found')
        this.dataService.changeAuditInfo(element);
        this.router.navigate(['/audits/auditInfo/', auditId]);
      }
    });
    */
  }


}
