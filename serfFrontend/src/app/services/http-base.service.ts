import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class HttpBaseService {
  api = environment.apiUrl;
  constructor(protected http: HttpClient) {}
}
