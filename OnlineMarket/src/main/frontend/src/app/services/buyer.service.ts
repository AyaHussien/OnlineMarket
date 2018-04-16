import { Injectable } from '@angular/core';
import { Http,Response,Headers,RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { UserEntity } from '../user/userEntity';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
@Injectable()

export class BuyerService
{
    private headers=new Headers({'Content-Type':'application/json'});
    private options=new RequestOptions({headers:this.headers});
    private user:UserEntity;

    constructor(private _http:Http){}
    setter(user:UserEntity)
    {
      this.user=user;
    }
    getter()
    {
        return this.user;
    }
    BuyRegister(v1:string,v2:string)
    {
        
        return this._http.post('http://localhost:8080/buyers/Bregister/'+v1+'/'+v2,this.options)
        .map((response:Response)=>response.json()).catch(this.errorHandler);
        
    }
    BuyLogin(email:string,pass:string)
    {
        return this._http.get('http://localhost:8080/buyers/login/'+email+'/'+pass,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
    
    }
    SellRegister(v1:string,v2:string)
    {
           
            console.log(v1);
            console.log(v2);
        return this._http.post('http://localhost:8080/sellers/Sregister/'+v1+'/'+v2,
        /*{"email": v1,
        "password": v2}*/this.options)
        .map((response:Response)=>response.json()).catch(this.errorHandler);
        
    }
    SellLogin(email:string,pass:string)
    {
        return this._http.get('http://localhost:8080/sellers/login/'+email+'/'+pass,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
    
    }
    AdmLogin(email:string,pass:string)
    {
        return this._http.get('http://localhost:8080/admin/login/'+email+'/'+pass,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
    }
    SysProd(name:string,brand:string,Lp:number,Hp:number)
    {
        return this._http.post('http://localhost:8080/sysprod/add/'+name+'/'+brand+'/'+Lp+'/'+Hp,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
    }
    Brand(name:string,des:string)
    {
        return this._http.post('http://localhost:8080/brand/add/'+name+'/'+des,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
        
    }
    addStore(v1:string,n:string,v2:string,v3:string)
    {
        return this._http.post('http://localhost:8080/sellers/AddStore/'+v1+'/'+n+'/'+v2+'/'+v3,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);        
    }
    addProd(v1:string,v2:string,v3:number,v4:string,v5:number)
    {
        return this._http.post('http://localhost:8080/sellers/AddProd/'+v1+'/'+v2+'/'+v3+'/'+v4+'/'+v5,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);        
    }
    addProdc(v1:string,v2:string,v3:number,v4:string,v5:number,v6:string)
    {
        return this._http.post('http://localhost:8080/sellers/collaAdd/'+v1+'/'+v2+'/'+v3+'/'+v4+'/'+v5+'/'+v6,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                
    }
    addColla(v1:string,v2:string,v3:string)
    {
        return this._http.post('http://localhost:8080/sellers/addColla/'+v1+'/'+v2+'/'+v3,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                
    }
    getStores(n:string)
    {
        return this._http.get('http://localhost:8080/sellers/list/'+n,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);        
    }
    getcollas(n:string)
    {
        return this._http.get('http://localhost:8080/sellers/listColla/'+n,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);        
        
    }
    getprods()
    {
        return this._http.get('http://localhost:8080/sellers/listProds',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);        
        
    }
    showProds(n:string)
    {
        return this._http.get('http://localhost:8080/sellers/listInstore/'+n,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);        
        
    }
    histo(n:string)
    {
        return this._http.get('http://localhost:8080/sellers/history/'+n,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);        
        
    }
    buy(v1:string,v2:number,v3:string,v4:String)
    {
        return this._http.post('http://localhost:8080/sellers/buy/'+v1+'/'+v2+'/'+v3+'/'+v4,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                
    }
    Psum()
    {
        return this._http.get('http://localhost:8080/admin/ProdStat/sum',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);        
    }
    Pavg()
    {
        return this._http.get('http://localhost:8080/admin/ProdStat/avg',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                
    }
    Usum()
    {
        return this._http.get('http://localhost:8080/admin//userStat/sum',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                
    }
    Uavg()
    {
        return this._http.get('http://localhost:8080/admin//userStat/avg',this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                        
    }
    EditO(v1:string,v2:string,v3:number)
    {
        return this._http.get('http://localhost:8080/sellers/Edit/'+v1+'/'+v2+'/'+v3,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                
    }
    DeleteO(v1:string,v2:string,v3:number)
    {
        return this._http.get('http://localhost:8080/sellers/Delete/'+v1+'/'+v2+'/'+v3,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                        
    }
    DeleteC(v1:string,v2:string,v3:number,v4:string)
    {
        return this._http.get('http://localhost:8080/sellers/collaDelete/'+v1+'/'+v2+'/'+v3+'/'+v4,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                                
    }
    EditC(v1:string,v2:string,v3:number,v4:string)
    {
        return this._http.get('http://localhost:8080/sellers/collaEdit/'+v1+'/'+v2+'/'+v3+'/'+v4,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                                
    }
    undo(v1:string,v2:number,v3:string,v4:string,v5:number,v6:number)
    {
        return this._http.get('http://localhost:8080/sellers/undo/'+v1+'/'+v2+'/'+v3+'/'+v4+'/'+v5+'/'+v6,this.options).map((response:Response)=>response.json()).catch(this.errorHandler);                        
    }
    errorHandler(error:Response)
    {
        return Observable.throw(error || "SERVER ERROR");
    }
}