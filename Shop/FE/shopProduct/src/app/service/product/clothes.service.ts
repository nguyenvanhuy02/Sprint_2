import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PageClothes} from "../../model/product/pageClothes";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ClothesService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(pageNumber: number): Observable<PageClothes> {
    return this.httpClient.get<PageClothes>(environment.api_url + '?page=' + pageNumber);
  }
}
