import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Reader} from '../model/reader';
import {PageReader} from '../model/pageReader';
import {environment} from '../../environments/environment';
import {ObserveOnSubscriber} from 'rxjs/internal/operators/observeOn';
import {Book} from '../model/book';

@Injectable({
  providedIn: 'root'
})
export class ReaderService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(pageNumber: number): Observable<PageReader> {
    return this.httpClient.get<PageReader>(environment.api_url + '?page=' + pageNumber);
  }

  deleteById(id: number | undefined): Observable<Reader> {
    return this.httpClient.delete(environment.api_url_delete + id);
  }

  create(reader: Reader): Observable<Reader> {
    return this.httpClient.post<Reader>(environment.api_url_create, reader);
  }

  findAllBook(): Observable<Book[]> {
    return this.httpClient.get<Book[]>(environment.api_url_book);
  }

  update(reader: Reader, id: number): Observable<Reader> {
    return this.httpClient.put<Reader>(environment.api_url + '/edit/' + id, reader);
  }
}
