import {Account} from '../account/account';

export interface User {
  id?: number;
  name?: string;
  account?: Account;
}
