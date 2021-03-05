export class AuditInfo {
    id: number;
    username: string = "";
    requestTime:Date;
    responseTime:Date;
    appTransaction:string = "";
    url:string = "";   
    responseStatus:string = "";    
    srcIp:string = "";
    targetIp: string = "";
    responseDesc:string = "";
    logs: string [] = [];
}
