package com.elian.mvpcalculator.ui.operationlist

import com.elian.mvpcalculator.data.model.Operation
import com.elian.mvpcalculator.data.repository.OperationStaticRepository

class OperationListInteractor(private val listener: IOperationListContract.IOnInteractorListener) :
    IOperationListContract.IInteractor,
    IOperationListContract.IRepositoryCallback
{
    public override fun load()
    {
        OperationStaticRepository.getList(this)
    }

    //region IRepositoryListCallback

    override fun onSuccess(list: List<Operation>)
    {
        listener.onSuccess(list)
    }

    //endregion
}