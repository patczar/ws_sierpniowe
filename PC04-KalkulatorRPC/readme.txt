Przykład usługi tworzonej w kolejności "top-down".
WSDL napisany w stylu RPC.

Zastosowane jest tu także podejście z oddzielniem interfejsu (tzw. "endpoint interface", SEI) od implementacji.
Podobnie jest w kolejnych wersjach.

Tutaj WSDL jest wgrywany na serwer, a implementacja odnosi się do niego za pomocą opcji wsdlLocation w adnotacji @WebService.
