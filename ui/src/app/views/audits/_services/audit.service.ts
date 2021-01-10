import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuditInfo } from '../_models/audit-info.model';

@Injectable({
  providedIn: 'root'
})
export class AuditService {
 
  
  constructor(private httpClient: HttpClient) { }

  getAllAudits(): Observable<AuditInfo[]> {
    let url: string = 'http://localhost:8080/app-meter/rest/api/audit/all';
    let response: Observable<AuditInfo[]> = this.httpClient.get<AuditInfo[]>(url);
    return response;
  }

  getAuditInfoById(auditId: number): Observable<AuditInfo> {
    let url: string = 'http://localhost:8080/app-meter/rest/api/audit/' + auditId;
    let response: Observable<AuditInfo> = this.httpClient.get<AuditInfo>(url);
    return response;
  }

  


}
