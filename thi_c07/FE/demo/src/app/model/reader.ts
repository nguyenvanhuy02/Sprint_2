import {Book} from './book';

export interface Reader {
  id?: number;
  name?: string;
  yearOld?: number;
  book?: Book;
}
