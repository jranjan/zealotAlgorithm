package com.backbase.api.models.v1.version.transaction;

import com.backbase.api.models.BackbaseApiResponse;
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
