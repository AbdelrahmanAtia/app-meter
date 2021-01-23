import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuditInfo } from '../../_models/audit-info.model';
import { AuditService } from '../../_services/audit.service';

@Component({
  templateUrl: './audits.component.html',
})
export class AuditsComponent implements OnInit {

  auditInfoList: AuditInfo[] = [];
  userNameSubStr: string;
  pageNumber: number;

  constructor(private auditService: AuditService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.listenToRouteParamChanges();
  }

  // called when any route param changes
  listenToRouteParamChanges() {
    this.route.params.subscribe(
      params => {
        this.userNameSubStr = (params['userName'] + "").trim();
        this.pageNumber = +params['pageNumber'];
        this.initializeAuditsList();
      });
  }

  initializeAuditsList() {
    this.auditService.getAudits(this.userNameSubStr, this.pageNumber).subscribe(
      (auditInfoList: AuditInfo[]) => this.auditInfoList = auditInfoList,
      (error) => console.log(error)
    );
  }

  viewAuditDetails(auditId: number): void {
    this.router.navigate(['/audits/auditInfo/', auditId]);
  }

  getAudits(userName: string, pageNumber: number) {
    this.userNameSubStr = userName;
    this.router.navigate(['/audits/', userName, pageNumber]);
  }

}
