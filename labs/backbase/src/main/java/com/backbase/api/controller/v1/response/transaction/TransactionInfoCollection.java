package com.backbase.api.controller.v1.response.transaction;

import com.backbase.api.controller.v1.response.BackbaseApiOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class TransactionInfoCollection extends BackbaseApiOutput {
    private ArrayList<TransactionInfo> transactions = new ArrayList<>();
}
