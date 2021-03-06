package com.elian.mvpcalculator.ui.calculator

import com.elian.mvpcalculator.base.IBasePresenter
import com.elian.mvpcalculator.data.model.Operation

interface ICalculatorContract
{
    /**
     * This interface indicates what the view has to do in the use cases.
     */
    interface IView : IRepositoryCallback
    {
        fun setNumber1EmptyError()
        fun setNumber2EmptyError()
        fun setResultError(message: String)
        fun cleanInputFieldsErrors()
    }

    interface IPresenter : IBasePresenter
    {
        fun onValidateData(operation: Operation)
    }

    interface IInteractor
    {
        fun validateData(operation: Operation)
    }

    interface IRepository
    {
        fun add(callback: IRepositoryCallback, operation: Operation)
    }

    interface IRepositoryCallback
    {
        fun onSuccess(operation: Operation)
        fun onFailure()
    }

    /**
     * Application's use cases.
     */
    interface IOnInteractorListener : IRepositoryCallback
    {
        fun onNumber1EmptyError()
        fun onNumber2EmptyError()
        fun onResultError(message: String)
    }
}