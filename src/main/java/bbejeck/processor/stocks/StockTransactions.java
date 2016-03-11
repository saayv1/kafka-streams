/*
 * Copyright 2016 Bill Bejeck
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bbejeck.processor.stocks;

import bbejeck.model.StockTransaction;

/**
 * User: Bill Bejeck
 * Date: 3/10/16
 * Time: 7:54 PM
 */
public class StockTransactions {

    public double amount;
    public String tickerSymbol;
    public int sharesPurchased;
    public int sharesSold;

    public StockTransactions add(StockTransaction transaction){
        if(tickerSymbol == null){
            tickerSymbol = transaction.getSymbol();
        }

        this.amount += transaction.getAmount();
        if(transaction.getType().equalsIgnoreCase("purchase")){
            this.sharesPurchased += transaction.getShares();
        } else{
            this.sharesSold += transaction.getShares();
        }
        return this;
    }

}
