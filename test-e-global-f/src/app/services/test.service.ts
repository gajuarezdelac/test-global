import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { TestEntity } from '../models/test-entity';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TestService {

  private host = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public newOperation(opinions: any): Observable<TestEntity> {
    return this.http.post<TestEntity>(`${this.host}/test/new-operation`, opinions)
  }

  public getResults(): Observable<TestEntity[]> {
    return this.http.get<TestEntity[]>(`${this.host}/test/list`)
  }



}
