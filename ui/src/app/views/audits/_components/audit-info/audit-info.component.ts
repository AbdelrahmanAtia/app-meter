import { Component, OnInit } from '@angular/core';
import { AuditInfo } from '../../_models/audit-info.model';
import { AuditService } from '../../_services/audit.service';

@Component({
  templateUrl: './audit-info.component.html',
})
export class AuditInfoComponent implements OnInit {

  auditInfo: AuditInfo = new AuditInfo();
  auditLogs: string[] = [];

  constructor(private auditService: AuditService) { }

  ngOnInit(): void {
    this.auditService.getAuditInfoById(1).subscribe(
      (response: AuditInfo) => {
        console.log(response);
        this.auditInfo = response;
        this.getLogs(response.appTransaction, response.requestTime);
      },
      (error) => console.log(error)
    );
  }

  getLogs(transactionId: string, requestDate: Date) {
    console.log("retrieving audit logs");
    this.auditService.getAuditLogs(transactionId, requestDate).subscribe(
      (logsLines: string[]) => {
        logsLines.forEach(l => this.auditLogs.push(l + "\n"));
      },
      (error) => console.log(error)
    );
  }

  showLogs(): string {
    return this.auditLogs.toString();
  }

}   
