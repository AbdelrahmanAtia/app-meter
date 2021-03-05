import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuditInfo } from '../_models/audit-info.model';
import { GetAuditLogsRequest } from '../_models/GetAuditLogsRequest';

@Injectable({
  providedIn: 'root'
})
export class AuditService {

  baseUrl = "http://localhost:8080/app-meter/rest";

  constructor(private httpClient: HttpClient) { }

  getAudits(searchTerm: string, pageNumber:number) {
    let url: string = this.baseUrl + '/api/audits?searchTerm=' + searchTerm + '&pageNumber=' + pageNumber;
    let response: Observable<AuditInfo[]> = this.httpClient.get<AuditInfo[]>(url);
    return response;
  }

  getAuditInfoById(auditId: number): Observable<AuditInfo> {
    let url: string = this.baseUrl + '/api/audits/' + auditId;
    let response: Observable<AuditInfo> = this.httpClient.get<AuditInfo>(url);
    return response;
  }
  
  getAuditEntryLogs(transactionId: string, requestDate: Date): Observable<string[]> {
    
    let getAuditLogsRequest = new GetAuditLogsRequest();
    getAuditLogsRequest.transactionId = transactionId;
    getAuditLogsRequest.requestDate = requestDate;

    let url: string = this.baseUrl + '/api/audits/logs';
    return this.httpClient.post<string[]>(url, getAuditLogsRequest);  //used post instead of get to prevent issues
                                                            //due to unsafe characters in url                                                        
  }


}
