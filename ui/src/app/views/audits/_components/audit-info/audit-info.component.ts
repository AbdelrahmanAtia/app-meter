import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuditInfo } from '../../_models/audit-info.model';
import { AuditService } from '../../_services/audit.service';
import { DataService } from '../../_services/data.service';

@Component({
  templateUrl: './audit-info.component.html',
})
export class AuditInfoComponent implements OnInit {

  auditInfo: AuditInfo = new AuditInfo();
  auditLogs: string[] = [];

  constructor(private auditService: AuditService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {

    //retrieve auditInfo details from auditInfoList component
    
    /*
    this.dataService.currentAuditInfo.subscribe(
      (response:AuditInfo) => {
        if(response != null){
          this.auditInfo = response;
          this.getLogs(response.appTransaction, response.requestTime);
        }
      },
      (error) => console.log(error)
    );
    */
    let auditId:number = this.route.snapshot.params.auditId;
    this.auditService.getAuditInfoById(auditId).subscribe(
      (response: AuditInfo) => {
        console.log(response);
        this.auditInfo = response;
        response.logs.forEach(l => this.auditLogs.push(l + "\n"));
        //this.getLogs(response.appTransaction, response.requestTime);
      },
      (error) => console.log(error)
    );
    
  }

  /*
  getLogs(transactionId: string, requestDate: Date) {
    console.log("retrieving audit logs");
    this.auditService.getAuditEntryLogs(transactionId, requestDate).subscribe(
      (logsLines: string[]) => {
        logsLines.forEach(l => this.auditLogs.push(l + "\n"));
      },
      (error) => console.log(error)
    );
  }
  */

  showLogs(): string {
    return this.auditLogs.toString();
  }

}   
