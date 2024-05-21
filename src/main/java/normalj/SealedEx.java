package normalj;


sealed class A permits B,C{
	
}
non-sealed class B extends A{
	
}
final class C extends A{
	
}

sealed interface X permits Y,Z{
	
}
non-sealed interface Y extends X{}

non-sealed class Z implements X{
	
}




public class SealedEx {

}
