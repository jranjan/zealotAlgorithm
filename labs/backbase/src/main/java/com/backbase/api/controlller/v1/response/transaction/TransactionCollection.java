package com.backbase.api.controlller.v1.response.transaction;

import com.backbase.api.controlller.v1.response.BackbaseApiResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class TransactionCollection extends BackbaseApiResponse {
    private ArrayList<Transaction> transactions = new ArrayList<>();
}
