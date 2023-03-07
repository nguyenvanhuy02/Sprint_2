import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PageClothes} from '../../model/product/pageClothes';
import {environment} from '../../../environments/environment';
import {Clothes} from '../../model/product/clothes';

@Injectable({
  providedIn: 'root'
})
export class ClothesService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(pageNumber: number): Observable<PageClothes> {
    return this.httpClient.get<PageClothes>(environment.api_url + '?page=' + pageNumber);
  }

  findAllHome(): Observable<any> {
    return this.httpClient.get<any>(environment.api_url_home);
  }

  detailClothes(id: number): Observable<Clothes> {
    return this.httpClient.get<Clothes>(environment.api_url + '/detail/' + id);
  }
}
