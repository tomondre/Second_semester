package Ex22_2.client.core;

import Ex22_2.client.view.chat.ChatViewModel;
import Ex22_2.client.view.clientListView.ClientListViewModel;
import Ex22_2.client.view.login.LoginViewModel;

public class ViewModelFactory
{
  private ChatViewModel chatVM;
  private LoginViewModel loginVM;
  private ClientListViewModel clientListVM;
  private ModelFactory mf;
  private static ViewModelFactory viewModelFactory = new ViewModelFactory(ModelFactory.getInstance());

  private ViewModelFactory(ModelFactory model)
  {
    mf = model;
    chatVM = new ChatViewModel(model.getModel());
    loginVM = new LoginViewModel(model.getModel());
    clientListVM = new ClientListViewModel(model.getModel());
  }

  public static ViewModelFactory getInstance()
  {
    return viewModelFactory;
  }

  public ChatViewModel getChatViewModel()
  {
    return chatVM;
  }

  public LoginViewModel getLoginViewModel()
  {
    return loginVM;
  }

  public ClientListViewModel getClientListViewModel()
  {
    return clientListVM;
  }
}
