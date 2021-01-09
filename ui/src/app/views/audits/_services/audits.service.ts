import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuditInfo } from '../_models/audit-info.model';

@Injectable({
  providedIn: 'root'
})
export class AuditsService {

  constructor(private httpClient: HttpClient) { }

  getAllAudits(): Observable<AuditInfo[]> {
    let url: string = 'http://localhost:8080/app-meter/rest/audits/all';
    let response: Observable<AuditInfo[]> = this.httpClient.get<AuditInfo[]>(url);
    return response;
  }

  


}
