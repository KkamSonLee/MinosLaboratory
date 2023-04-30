package com.angdroid.minoslaboratory;

import org.jetbrains.annotations.NotNull;

public class Test {

    public final Object invokeSuspend(@NotNull Object $result) {
        int label = 0;
        lable2:
        {

            switch (label) {
                case 0: {

                    new String("sad");
                    label = 1;
                    break;
                }
                case 1: {


                    label = 2;
                    new String("asd");
                    break;
                }

                case 2: {

                    new String("asaaa");
                    break lable2;
                }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

        }


        return "sada";
    }

}
