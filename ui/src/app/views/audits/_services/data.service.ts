import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { AuditInfo } from '../_models/audit-info.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {


  /*
  private auditInfoSource = new BehaviorSubject<AuditInfo>(null);
  currentAuditInfo = this.auditInfoSource.asObservable();

  constructor() { }

  changeAuditInfo(auditInfo:AuditInfo){
    this.auditInfoSource.next(auditInfo);
  } 
  */ 

}
